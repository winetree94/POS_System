import React, {Fragment} from 'react';
import SideBar from './comm/SideBar.js';
import Header from './comm/Header.js';
import {
	Row,
	Col
} from 'reactstrap';
import Axios from 'axios';
import {getOrder} from './js/PosData.js';
import SaleMain from './sale/SaleMain.js';

export default class App extends React.Component {
	
	state = {
		error: null,
		isLoaded: false,
		orderList: [],
		cashBook: [],
		menu: [],
		invoice: [],
		reservation: [],
		table: []
	}
	
	constructor(props) {
		super(props);
		
		Axios.get('/pos/1/order').then((response) => {
			this.setState({
				orderList: this.state.orderList.concat(response.data)
			})
			
		});
		Axios.get('/pos/1/cashbook').then((response) => {
			this.setState({
				cashBook: this.state.cashBook.concat(response.data)
			})
		});
		
		Axios.get('/pos/1/menu').then((response) => {
			this.setState({
				menu: this.state.cashBook.concat(response.data)
			})
		});
		
		Axios.get('/pos/1/invoice').then((response) => {
			this.setState({
				invoice: this.state.cashBook.concat(response.data)
			})
		});
		
		Axios.get('/pos/1/reservation').then((response) => {
			this.setState({
				reservation: this.state.cashBook.concat(response.data)
			})
		});
		
		Axios.get('/pos/1/table').then((response) => {
			this.setState({
				table: this.state.cashBook.concat(response.data)
			})
		});
	}
	
	componentDidMount() {
		
		setInterval(() => {
			
			Axios.get('/pos/1/order').then((response) => {
				this.setState({
					orderList: []
				})
				this.setState({
					orderList: this.state.orderList.concat(response.data)
				})
				
			});
			Axios.get('/pos/1/cashbook').then((response) => {
				this.setState({
					cashBook: []
				})
				this.setState({
					cashBook: this.state.cashBook.concat(response.data)
				})
			});
			
			Axios.get('/pos/1/menu').then((response) => {
				this.setState({
					menu: []
				})
				this.setState({
					menu: this.state.cashBook.concat(response.data)
				})
			});
			
			Axios.get('/pos/1/invoice').then((response) => {
				this.setState({
					invoice: []
				})
				this.setState({
					invoice: this.state.cashBook.concat(response.data)
				})
			});
			
			Axios.get('/pos/1/reservation').then((response) => {
				this.setState({
					reservation: []
				})
				this.setState({
					reservation: this.state.cashBook.concat(response.data)
				})
			});
			
			Axios.get('/pos/1/table').then((response) => {
				this.setState({
					table: this.state.cashBook.concat(response.data)
				})
			});
			
			const {error, isLoaded} = this.state;
			
			this.setState({
				isLoaded: true
			})
			
		}, 3000)
	};
	
	getData = () => {
		console.log(this.state);
	}
	
	render() {
		const {error, isLoaded, orderList} = this.state;
		
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
					<Header></Header>
					<div className={"container"} style={{maxWidth: "1280px"}}>
						<Row>
							<Col md={2} style={{padding: "0", maxWidth: "193px"}}>
								<SideBar></SideBar>
							</Col>
							<Col style={{maxWidth: "1083px", padding: "0"}}>
								<SaleMain></SaleMain>
								<input type="button" onClick={this.getData} value={"누르세요."}/>
								<p>{JSON.stringify(this.state)}</p>
							</Col>
						</Row>
					</div>
				</Fragment>
			)
		}
	}
}
