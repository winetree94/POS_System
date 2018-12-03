import React, {Fragment} from 'react';
import SideBar from './comm/SideBar.js';
import Header from './comm/Header.js';
import {
	Row,
	Col
} from 'reactstrap';
import Axios from 'axios';
import Sale_Main from './Sale/Sale_Main.js';
import Loading from './comm/Loading';
import Invoice from './Invoice/Invoice';
import Cashbook from './Cashbook/Cashbook';
import {
	Route, Redirect
} from 'react-router-dom'
import Category from "./Category/Category";
import TableManagement from "./TableManagement/TableManagement";
import TableDetail from "./Sale/Table_Main";

export default class App extends React.Component {
	
	state = {
		isLoaded: false,
		isLogin: false
	};
	
	constructor(props) {
		super(props);
		
		
		Axios.get('/api/auth').then(response => {
			this.setState({
				auth: response.data
			}, () => {
				this.setState({
					isLogin: true
				});
				
				setTimeout(() => {
					this.setState({
						isLoaded: true
					})
				}, 1500)
			});
			
		});
	}
	
	render() {
		const {isLogin, isLoaded} = this.state;
		
		if (!isLoaded) {
			return (
				<Loading msg={" POS 로딩중입니다. "}></Loading>
			)
		}
		
		// 렌더링
		else {
			
			return (
				<Fragment>
					<Header auth={this.state.auth}></Header>
					<div className={"container"} style={{maxWidth: "1280px"}}>
						<Row>
							<Col style={{maxWidth: "193px"}}>
								<SideBar toggle={this.switch}></SideBar>
							</Col>
							<Col>
								<Route path="/category" component={Category}/>
								<Route path="/table" component={TableManagement}/>
								<Route path="/" exact={true} component={Sale_Main}/>
								<Route path="/sale" exact={true} component={Sale_Main}/>
								<Route path="/analyze" component={Sale_Main}/>
								<Route path="/management" component={Sale_Main}/>
								<Route path="/invoice" component={Invoice}/>
								<Route path="/cashbook" component={Cashbook}/>
								<Route path="/tabledetail/:table_seq" exact={true} component={TableDetail}/>
							</Col>
						</Row>
					</div>
				</Fragment>
			
			)
		}
	}
}
