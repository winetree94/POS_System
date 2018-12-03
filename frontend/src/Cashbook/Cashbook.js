import React from "react";
import Cashbook_List from "./Cashbook_List";
import Axios from "axios";
import CashbookEdit from "./Cashbook_Edit";
// import common from '../utility/common-utility';
import qs from 'qs'
import Loading from '../comm/Loading';
import InvoiceList from "../Invoice/InvoiceList";
import InvoiceDetail from "../Invoice/InvoiceDetail";
import {Spring, Trail} from "react-spring";


export default class Cashbook extends React.Component {
	
	state = {
		data: [],
		day:[],
		isLoad: false
	};
	
	constructor(props) {
		super(props);
	}
	
	componentDidMount = () => {
		this.interval = this.setIntervalAndExecution(this.dataUpdater, 3000);
	};
	
	setIntervalAndExecution = (callback, timeout) => {
		callback();
		return (setInterval(callback, timeout));
	};
	
	dataUpdater = () => {
		Axios.get('/api/cashbook').then((response) => {
			this.setState({
				data: response.data,
				isLoad : true
			})
		});
		Axios.get('/api/cashbook/day').then(response=>{
			this.setState({
				day : response.data
			})
		})
	};
	
	createHandler = (info) => {
		console.log(info.cash_deposit);
		Axios.post('/api/cashbook', qs.stringify({
				cash_deposit: info.cash_deposit
			})
		).then((response) => {
			this.dataUpdater();
		});
	};
	
	render() {
		const {isLoad} = this.state;
		
		if (!isLoad) {
			return <Loading msg="현금출납부를 로딩중입니다."></Loading>
			
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
								<h1 className={"content-header-1"}>
									
									<Trail
										items={['현', '금', '출', '납', '부']}
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
								
								
								<div className="row">
									<div className="col">
										<h4 className="content-header-4">
											실시간 입출금 내역
										</h4>
										<Cashbook_List data={this.state.data}/>
									</div>
									<div className="col">
										<h4 className="content-header-4">
											일별 정산 금액
										</h4>
										<CashbookEdit onCreate={this.createHandler} day={this.state.day}/>
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