import React from 'react';
import {Col, Row, Button, Card, CardBody, CardImg, CardSubtitle, CardText, CardTitle} from "reactstrap";
import Axios from 'axios';
import $ from 'jquery';
import TableItem from "../TableManagement/TableItem";
import { Link } from 'react-router-dom';

class Sale_TableItem extends React.Component {
	
	state = {
		tableItem : {},
		tableOrder : []
	};
	
	componentDidMount=()=>{
		
		this.interval = setInterval(()=>{
		const {table_seq} = this.props.tableItem;
		Axios.get('/api/order/'+table_seq).then(response=>{
			this.setState({
				tableOrder : response.data
			})
		});
		},1000);
	};
	
	render() {
		
		const {store_seq, table_seq, table_name, reservation, min_people, max_people, delflag} = this.props.tableItem;
		const {tableOrder} = this.state;
		
		const lists = tableOrder.map(tableItem => (
			
			<CardText
				key={tableItem.menu_seq}
			>{tableItem.menu_name}   :   {tableItem.count} 개</CardText>
			
		));
		// <Link className="nav-link" exact={"true"} to="/sale">판매</Link>
		return (
			<Link className="nav-link" to={"/tabledetail/"+table_seq}>
			
						<Card
							className={"col-md"}
							style={{height:"100px", margin:"10px", width:"150px"}}
							onClick={()=>{this.props.onClick(this.props.tableItem)}}
						>
							<CardBody style={{padding:"3px"}}>
								<CardTitle></CardTitle>
								<CardSubtitle>{table_name}</CardSubtitle>
								{lists}
							</CardBody>
						</Card>
			</Link>
		)
	}
	
	componentWillUnmount() {
		clearInterval(this.interval);
	}
}

export default Sale_TableItem;