import React from 'react';
import Axios from "axios";
import {Button, Col, Row} from "reactstrap";
import Table_MenuList from "./Table_MenuList";
import Qs from 'qs';
import Table_OrderList from './Table_OrderList';
import {Link} from "react-router-dom";
import Comma from '../utility/common-utility'

class Table_Main extends React.Component {
	
	static defaultProps = {
		match : {
			params : {
				table_seq : 0
			}
		}
	};
	
	state = {
		tableOrder: [],
		category: [],
		menus: [],
		menu: {},
		table: {},
		activeTab: '',
		isLoad: false,
		sumOrder:0,
		ref : 0
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
			
			Axios.get('/api/order/' + this.state.table.table_seq + '/ref').then(response => {
				this.setState({
					ref: response.data.ref
				});
				
			});

			if (this.state.activeTab !== '') {
				Axios.get("/api/category/menulists/" + this.state.activeTab)
					.then(response => {
						this.setState({
							menus: response.data
						});
					});
			}
			
		}, 300);
		
		Axios.get('/api/table/' + this.props.match.params.table_seq).then(response => {
			this.setState({
				table: response.data
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
		
		
		this.setState({
			menu: {...menu}
		},()=>{
		Axios.post('/api/order', Qs.stringify({
				table_seq: this.props.match.params.table_seq,
				menu_seq: this.state.menu.menu_seq,
				ref: this.state.ref
			})
		);
		});
		
	};
	
	paymentBtn=()=>{
		
		Axios.post('/api/invoice', Qs.stringify({
			table_seq:this.props.match.params.table_seq,
			ref:this.state.ref
		}));
	
	};
	
	render() {
		console.log(this.state.ref);
	
		const lists = this.state.tableOrder.map(item => (
			<Table_OrderList
				key={item.menu_seq}
				item={item}
				table_seq={this.props.match.params.table_seq}
				add={this.crudClickEventHandler}
			/>
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
						<Table_MenuList
							category={this.state.category}
							activeTab={this.state.activeTab}
							toggle={this.toggle}
							menus={this.state.menus}
							onClick={this.crudClickEventHandler}
						/>
						<div>
							
							<Row style={{padding: "15px", width: "100%", height: "100%"}}>
								<Col style={{width: "100%", height: "100%", padding: "15px"}}>
									<Link to="/"><Button
										onClick={this.paymentBtn}
										style={{width: "100%", height: "70px"}}
										color="primary" size="lg"
										name="new"
									>결제</Button></Link>
								</Col>
								<Col style={{width: "100%", height: "100%", padding: "15px"}}>
									<Link to={"/"}>
									<Button
										style={{width: "100%", height: "70px"}}
										color="danger" size="lg"
										name="delete"
									>
										뒤로가기</Button></Link>
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

export default Table_Main;