import React from "react";
import Axios from "axios";
import {Row, Col} from "reactstrap";
import InvoiceList from "./InvoiceList";
import InvoiceItem from "./InvoiceItem";
import InvoiceDetail from "./InvoiceDetail";
import qs from 'qs';
import Loading from "../comm/Loading";
import {Spring, Trail} from "react-spring";

export default class Invoice extends React.Component {
	state = {
		invoiceList: [],
		invoiceDetail: {},
		orderList: [],
		value: "",
		Empty: false,
		isLoad: false
	};
	
	componentDidMount = () => {
		this.interval = this.setIntervalAndExecution(this.dataUpdater, 3000);
	};
	
	dataUpdater = () => {
		Axios.get("/api/invoice").then(response => {
			console.log("invoice updated");
			this.setState({
				invoiceList: response.data,
				isLoad: true
			});
		});
	};
	
	setIntervalAndExecution = (callback, timeout) => {
		callback();
		return (setInterval(callback, timeout));
	};
	
	
	clickEventHandler = param => {
		this.setState({
				invoiceDetail: {...param}
			},
			() => {
				Axios
					.get("/api/invoice/order/" + this.state.invoiceDetail.ref)
					.then(response => {
						this.setState({
							orderList: response.data
						});
					});
			}
		);
	};
	
	refund = () => {
		Axios.post('/api/invoice/' + this.state.invoiceDetail.ref + '/refund').then(response => {
			this.dataUpdater();
		})
	};
	
	render() {
		const {isLoad} = this.state;
		
		if (!isLoad) {
			return (<div></div>)
		} else {
			
			return (
				
				<Spring
					from={{
						opacity: 0,
						transform: 'translateY(30px)'
					}}
					to={{
						opacity: 1,
						transform: 'translateY(0px)'
					}}>
					{props =>
						<div style={props}>
							
							<div className={"container content"}>
								
								<h1 className={"content-header-1"} onClick={this.clickEventHandler}>
									<Trail
										items={['판', '매', '내', '역']}
										from={{
											opacity: 0,
											transform: 'translate3d(0,40px,0)'
										}}
										to={{
											opacity: 1,
											transform: 'translate3d(0,0px,0)'
										}}
									>
										{item => props => (
											<span style={props}>{item}</span>
										)}
									</Trail>
								</h1>
								
								<div className={"row"}>
									<div className={"col"}>
										<h4 className={"content-header-4"}>거래 내역</h4>
										<InvoiceList
											invoiceList={this.state.invoiceList}
											select={this.clickEventHandler}
										/>
									</div>
									<div className={"col"}>
										<h4 className={"content-header-4"}>영수증</h4>
										<InvoiceDetail
											orderList={this.state.orderList}
											invoiceDetail={this.state.invoiceDetail}
											refund={this.refund}
										/>
									</div>
								</div>
							</div>
						</div>}
				</Spring>
			
			);
		}
	}
	
	componentWillUnmount() {
		clearInterval(this.interval);
	}
}
