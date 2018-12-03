import React from "react";
import comma from '../utility/common-utility';
import Axios from "axios";
import OrderItem from './OrderItem';
import uuidv5 from 'uuid/v4';
import {Button, Row, Col} from 'reactstrap';
import NewWindow from 'react-new-window';

export default class InvoiceDetail extends React.Component {
	
	state = {
		print: false
	};
	
	static defaultProps = {
		invoiceDetail: {},
		orderList: [],
	};
	
	constructor(props) {
		super(props);
	}
	
	printInvoice = (e) => {
		console.log(e);
		
		window.open('/pos/invoice');
		
	};
	
	render() {
		const {
			invoice_seq,
			discount_amount,
			final_amount,
			menu_amount,
			paid_date,
			payment_method,
			ref,
			store_seq,
			sumorder,
			table_seq,
			tax_amount,
			total_amount
		} = this.props.invoiceDetail;
		
		const {orderList} = this.props;
		
		const lists = orderList.map(order => (
			<OrderItem
				key={order.menu_seq}
				order={order}
			/>
		));
		
		return (
			<div>
				<div className="content-box" style={{height: "400px"}}>
					<table className="table">
						<thead>
						<tr>
							<th>상품명</th>
							<th>금액</th>
							<th>개수</th>
							<th>합계금액</th>
						</tr>
						</thead>
						<tbody>
						{lists}
						</tbody>
					</table>
					
					<table className="table">
						<tbody>
						<tr>
							<td>테이블번호 :</td>
							<td className="text-right">{table_seq}</td>
						</tr>
						<tr>
							<td>주문금액 :</td>
							<td className="text-right">{menu_amount != undefined ? comma(menu_amount) : ""}</td>
						</tr>
						<tr>
							<td>부가세 :</td>
							<td className="text-right">{tax_amount != undefined ? comma(tax_amount) : ""}</td>
						</tr>
						<tr>
							<td>합계금액 :</td>
							<td className="text-right">{total_amount != undefined ? comma(total_amount) : ""}</td>
						</tr>
						<tr>
							<td>할인금액 :</td>
							<td className="text-right"> - {total_amount != undefined ? comma(discount_amount) : ""}</td>
						</tr>
						<tr>
							<td>결제방식 :</td>
							<td className="text-right">{payment_method}</td>
						</tr>
						<tr>
							<td>결제일자 :</td>
							<td className="text-right">{paid_date}</td>
						</tr>
						<tr>
							<td>최종금액 :</td>
							<td className="text-right">{final_amount != undefined ? comma(final_amount) : ""}</td>
						</tr>
						</tbody>
					</table>
				</div>
				<Row style={{padding: "15px", width: "100%", height: "100%"}}>
					<Col style={{width: "100%", height: "100%", padding: "15px"}}><Button style={{width: "100%", height: "70px"}}
					                                                                      color="primary" size="lg"
					                                                                      onClick={this.printInvoice}>영수증
						재출력</Button></Col>
					<Col style={{width: "100%", height: "100%", padding: "15px"}}>
						<Button style={{width: "100%", height: "70px"}}
						        color="danger" size="lg"
						        onClick={this.props.refund}
						>환 불</Button></Col>
				</Row>
			</div>
		);
	}
}
