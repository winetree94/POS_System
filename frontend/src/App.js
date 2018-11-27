import React, {Fragment} from 'react';
import SideBar from './comm/SideBar.js';
import Header from './comm/Header.js';
import {
	Row,
	Col
} from 'reactstrap';
import Axios from 'axios';
import SaleMain from './sale/SaleMain.js';

export default class App extends React.Component {
	
	state = {
		error: null,
		isLoaded: false,
		auth: [],
		orderList: [],
		cashBook: [],
		menu: [],
		invoice: [],
		reservation: [],
		table: []
	};
	
	constructor(props) {
		super(props);
		Axios.get('/api/auth').then(response => {
			if (response.data === "" || response.data === null || response.data === undefined) {
				window.location.href = "/errorpage";
				console.log("fail");
			} else {
				this.setState({
					auth: this.state.auth.concat(response.data)
				})
			}
		});
	}
	
	componentDidMount() {
		
		setInterval(() => {
			Axios.all([
				Axios.get('/api/' + this.state.auth[0].store_seq + '/order'),
				Axios.get('/api/' + this.state.auth[0].store_seq + '/cashbook'),
				Axios.get('/api/' + this.state.auth[0].store_seq + '/menu'),
				Axios.get('/api/' + this.state.auth[0].store_seq + '/invoice'),
				Axios.get('/api/' + this.state.auth[0].store_seq + '/reservation'),
				Axios.get('/api/' + this.state.auth[0].store_seq + '/table'),
			]).then(Axios.spread((orderRes, cashbookRes, menuRes, invoiceRes, reservationRes, tableRes) => {
				console.log(orderRes.data, cashbookRes.data, menuRes.data, invoiceRes.data, reservationRes.data, tableRes.data);
				
				this.setState({
					orderList: orderRes.data,
					cashBook: cashbookRes.data,
					menu: menuRes.data,
					invoice: invoiceRes.data,
					reservation: reservationRes.data,
					table: tableRes.data,
				}, () => {
					this.setState({
						isLoaded: true
					});
				});
			}));
		}, 3000)
	};
	
	render() {
		const {isLoaded} = this.state;
		
		if (!isLoaded) {
			return (
				<Fragment>
					<div className="spinner">
						<div className="double-bounce1"></div>
						<div className="double-bounce2"></div>
					</div>
					<h1 className={"display-5 text-center"}>POS 로딩중입니다.</h1>
				</Fragment>
			)
		} else {
			
			return (
				<Fragment>
					<Header service_id={this.state.auth[0].service_id}></Header>
					<div className={"container"} style={{maxWidth: "1280px"}}>
						<Row>
							<Col md={2} style={{padding: "0", maxWidth: "193px"}}>
								<SideBar></SideBar>
							</Col>
							<Col style={{maxWidth: "1083px", padding: "0"}}>
								<SaleMain {...this.state}></SaleMain>
							</Col>
						</Row>
					</div>
				</Fragment>
			)
		}
	}
}
