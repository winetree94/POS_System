import React, {Fragment} from 'react';
import SideBar from './comm/SideBar.js';
import Header from './comm/Header.js';
import {
	Row,
	Col
} from 'reactstrap';
import Axios from 'axios';
import SaleMain from './Sale/SaleMain.js';
import Loading from './comm/Loading';
import Invoice from './Invoice/Invoice';
import Cashbook from './Cashbook/Cashbook';
import {
	Route, Redirect
} from 'react-router-dom'
import Category from "./Category/Category";
import TableManagement from "./TableManagement/TableManagement";

export default class App extends React.Component {
	
	state = {
		isLoaded: false,
		isLogin: false,
		auth: [],
	};
	
	constructor(props) {
		super(props);
		this.getAuth((response) => {
			
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
				}, 2000)
			})
			
		});
	}
	
	// 계정 정보를 수령 후 callback 함수에 response 를 전달
	getAuth = (callback) => {
		Axios.get('/api/auth').then(response => {
			callback(response);
		});
	};
	
	// 매장 정보를 수령 후 callback 함수에 response 를 전달
	updateStore = (callback) => {
		
		Axios.all([
			Axios.get('/api/order'),
			Axios.get('/api/cashbook'),
			Axios.get('/api/menu'),
			Axios.get('/api/invoice'),
			Axios.get('/api/reservation'),
			Axios.get('/api/table'),
		]).then(Axios.spread((orderRes, cashbookRes, menuRes, invoiceRes, reservationRes, tableRes) => {
			
			const response = {
				orderList: orderRes.data,
				cashbook: cashbookRes.data,
				menu: menuRes.data,
				invoice: invoiceRes.data,
				reservation: reservationRes.data,
				table: tableRes.data
			};
			
			console.log("render");
			
			callback(response);
		}));
	};
	
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
					<Header service_id={this.state.auth.service_id}></Header>
					<div className={"container"} style={{maxWidth: "1280px"}}>
						<Row>
							<Col style={{maxWidth: "193px"}}>
								<SideBar toggle={this.switch}></SideBar>
							</Col>
							<Col>
								<Route path="/category" component={Category} />
								<Route path="/table" component={TableManagement} />
								<Route path="/" exact={true} component={SaleMain}/>
								<Route path="/sale" exact={true} component={SaleMain}/>
								<Route path="/analyze" component={SaleMain}/>
								<Route path="/management" component={SaleMain}/>
								<Route path="/invoice" component={Invoice}/>
								<Route path="/cashbook" component={Cashbook}/>
							</Col>
						</Row>
					</div>
				</Fragment>
			
			)
		}
	}
}
