import React from 'react';
import {Col, Row, Button, Card, CardBody, CardImg, CardSubtitle, CardText, CardTitle} from "reactstrap";
import Axios from 'axios';
import $ from 'jquery';
import TableItem from "../TableManagement/TableItem";
import {Link} from 'react-router-dom';
import Loading from "../comm/Loading";

class Sale_TableItem extends React.Component {
	
	state = {
		tableItem: {},
		tableOrder: [],
		isLoad: false
	};
	
	componentDidMount = () => {
		this.interval = this.setIntervalAndExecution(this.dataUpdate, 3000);
	};
	
	dataUpdate = () => {
		const {table_seq} = this.props.tableItem;
		Axios.get('/api/order/' + table_seq).then(response => {
			this.setState({
				tableOrder: response.data,
				isLoad: true
			})
		});
	};
	
	setIntervalAndExecution = (callback, timeout) => {
		callback();
		return (setInterval(callback, timeout));
	};
	
	render() {
		
		console.log(this.state);
		
		if (!this.state.isLoad) {
			return <div/>
		} else {
			
			const {store_seq, table_seq, table_name, reservation, min_people, max_people, delflag} = this.props.tableItem;
			const {tableOrder} = this.state;
			
			const lists = tableOrder.map(tableItem => (
				
				<p
					className="text-center"
					style={{margin: "0px", overflow: "auto"}}
					key={tableItem.menu_seq}
				>{tableItem.menu_name} : {tableItem.count} 개</p>
			
			));

			return (
				<Link className="nav-link" to={"/tabledetail/" + table_seq}>
					<Card
						className={"col-md"}
						style={{height: "150px", margin: "auto auto", width: "220px", overflow: "auto"}}
					>
						<CardBody style={{padding: "3px", marginTop: "10px"}}>
							<CardTitle className="text-center">{table_name}</CardTitle>
							<p className={"text-center"} style={{margin: "0px"}}>
							 	{tableOrder[0] != null?"주문 시작 시간 : "+tableOrder[0].order_date.substring(11, 13)+"시 "+tableOrder[0].order_date.substring(14, 16)+"분":""}
								</p>
							{lists}
						</CardBody>
					</Card>
				</Link>
			)
		}
	}
	
	componentWillUnmount() {
		clearInterval(this.interval);
	}
}

export default Sale_TableItem;