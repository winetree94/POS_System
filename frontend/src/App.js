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
import ErrorPage from './comm/ErrorPage';
import Analyze from './Analyze/Analyze';
import Invoice from './Invoice/Invoice';
import Cashbook from './Cashbook/Cashbook';
import {
	Route
} from 'react-router-dom'

export default class App extends React.Component {
	
	state = {
		isLoaded: false,
		isLogin: false,
		auth: [],
		data: {}
	};
	
	constructor(props) {
		super(props);
		
		this.getAuth((response) => {
			
			// response 에서 계정정보를 수령
			const {service_id, store_seq} = response.data;
			
			// response 의 계정정보를 state 에 반영
			if (service_id && store_seq) {
				this.setState({
					auth: response.data,
					isLogin: true
					// 계정 정보를 받은 후
				}, () => {
					this.updateStore((response) => {
						this.setState({
							data: response
						}, () => {
							setTimeout(() => {
								this.setState({
									isLoaded: true
								})
							}, 100)
							setInterval(() => {
								this.updateStore(() => {
								})
							}, 3000);
						})
					})
				});
			} else {
				this.setState({
					isLoaded: false,
					isLogin: false
				})
			}
		})
	}
	
	componentDidMount = () => {
	
	};
	
	// 계정 정보를 수령 후 callback 함수에 response 를 전달
	getAuth = (callback) => {
		Axios.get('/api/auth').then(response => {
			callback(response);
		});
	};
	
	// 매장 정보를 수령 후 callback 함수에 response 를 전달
	updateStore = (callback) => {
		
		Axios.all([
			Axios.get('/api/' + this.state.auth.store_seq + '/order'),
			Axios.get('/api/' + this.state.auth.store_seq + '/cashbook'),
			Axios.get('/api/' + this.state.auth.store_seq + '/menu'),
			Axios.get('/api/' + this.state.auth.store_seq + '/invoice'),
			Axios.get('/api/' + this.state.auth.store_seq + '/reservation'),
			Axios.get('/api/' + this.state.auth.store_seq + '/table'),
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
		
		// 로그인하지 않았을 경우 , 잘못된 접근
		if (!isLogin) {
			return (
				<ErrorPage msg={"로그인을 먼저 해주세요."}></ErrorPage>
			)
		}
		
		// 로딩 창을 띄움과 동시에 데이터 로딩
		else if (!isLoaded) {
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
							<Col style={{maxWidth:"193px"}}>
								<SideBar toggle={this.switch}></SideBar>
							</Col>
							<Col>
								<Route path="/sale" component={SaleMain}/>
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
