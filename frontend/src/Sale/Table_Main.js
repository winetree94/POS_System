import React from 'react';
import Axios from "axios";
import {Button, Col, Row} from "reactstrap";
import Sale_MenuList from "./Sale_MenuList";
import Table_OrderList from './Sale_TableList.js';
import Qs from 'qs';

class Sale_TableDetail extends React.Component {
	
	static defaultProps = {};
	
	state = {
		tableOrder: [],
		category: [],
		menus: [],
		menu: {},
		table: {},
		activeTab: '',
		isLoad: false
	};
	
	componentDidMount = () => {
		
		this.interval = setInterval(() => {
			const {table_seq} = this.props.match.params;
			Axios.get('/api/order/' + table_seq).then(response => {
				this.setState({
					tableOrder: response.data
				})
			});
			
			Axios.get('/api/menu').then((response) => {
				this.setState({
					category: response.data
				})
			});
			
			if (this.state.activeTab !== '') {
				Axios.get("/api/category/menulists/" + this.state.activeTab)
					.then(response => {
						this.setState({
							menus: response.data
						});
					});
			}
		}, 1000);
		
		Axios.get('/api/table/' + this.props.match.params.table_seq).then(response => {
			this.setState({
				table: response.data
			}, ()=>{
				Axios.get('/api/order/' + this.state.table.table_seq + '/ref').then(response => {
					this.setState({
						ref: response.data.ref
					});
				});
			})
		})
		
	};
	
	toggle = (CATEG_NAME) => {
		if (this.state.activeTab !== CATEG_NAME) {
			this.setState({
				activeTab: CATEG_NAME
			});
		}
	};
	
	crudClickEventHandler = (menu) => {
		// menu_seq, table_seq, ref
		
		console.log(this.state);
		
		this.setState({
			menu: {...menu}
		});
		
		Axios.post('/api/order', Qs.stringify({
				table_seq: this.state.table.table_seq,
				menu_seq: menu.menu_seq,
				ref: this.state.ref,
			})
		)
	};
	
	render() {
		
		const lists = this.state.tableOrder.map(item => (
				<tr key={item.menu_seq}>
					<td>{item.menu_name}</td>
					<td>{item.count}</td>
					<td>{item.price}</td>
					<td>{item.sum}</td>
				</tr>
			)
		);
		
		return (
			<div className={"container content"}>
				<h1 className={"content-header-1"}>
					테이블 정보
				</h1>
				
				<div className={"row"}>
					<div className={"col"}>
						<h4 className={"content-header-4"}>주문 내역</h4>
						<div className={"content-box"}>
							
							<table className={"table"}>
								
								<thead>
								<tr>
									<td>상품명</td>
									<td>수량</td>
									<td>단가</td>
									<td>합계</td>
								</tr>
								</thead>
								
								<tbody>
								{lists}
								</tbody>
							
							</table>
						
						</div>
					</div>
					
					
					<div className={"col"}>
						<h4 className={"content-header-4"}>추가 주문</h4>
						<Sale_MenuList
							category={this.state.category}
							activeTab={this.state.activeTab}
							toggle={this.toggle}
							menus={this.state.menus}
							onClick={this.crudClickEventHandler}
						/>
						<div>
							
							<Row style={{padding: "15px", width: "100%", height: "100%"}}>
								<Col style={{width: "100%", height: "100%", padding: "15px"}}>
									<Button
										style={{width: "100%", height: "70px"}}
										color="primary" size="lg"
										name="new"
									>결제</Button>
								</Col>
								<Col style={{width: "100%", height: "100%", padding: "15px"}}>
									<Button
										style={{width: "100%", height: "70px"}}
										color="info" size="lg"
										name="edit"
									>할인</Button>
								</Col>
								<Col style={{width: "100%", height: "100%", padding: "15px"}}>
									<Button
										style={{width: "100%", height: "70px"}}
										color="danger" size="lg"
										name="delete"
									>취소</Button>
								</Col>
							</Row>
						</div>
					</div>
				</div>
			
			</div>
		)
	}
	
	componentWillUnmount = () => {
		clearInterval(this.interval);
	}
}

export default Sale_TableDetail;