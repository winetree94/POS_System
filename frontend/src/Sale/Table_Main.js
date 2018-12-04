import React, {Fragment} from 'react';
import Axios from "axios";
import {Button, Col, Row} from "reactstrap";
import Table_MenuList from "./Table_MenuList";
import Qs from 'qs';
import Table_OrderList from './Table_OrderList';
import {Link} from "react-router-dom";
import Comma from '../utility/common-utility'
import Loading from '../comm/Loading';
import Table_Payment from './Table_Payment';
import {Animated} from "react-animated-css";
import {Spring, Trail, Transition} from "react-spring";

class Table_Main extends React.Component {
	
	static defaultProps = {
		match: {
			params: {
				table_seq: 0
			}
		}
	};
	
	state = {
		tableOrder: [], // table의 주문정보
		category: [], // 테이블의 카테고리 정보
		menus: [], // 카테고리의 메뉴 목록
		menu: {}, // 선택한 메뉴
		table: {}, // 현재 보고있는 테이블의 정보
		sumOrder: 0, // 현재 주문의 합계 금액
		activeTab: '',
		ref: 0 // 주문 묶음의 고유 번호
	};
	
	componentDidMount = () => {
		this.interval = this.setIntervalAndExecution(this.dataUpdater, 5000);
	};
	
	dataUpdater = () => {
		
		// ref 상태를 가져옴 기존 ref가 있다면 그것을 이용하며, 없다면 서버에서 신규 ref를 발급받음.
		Axios.get('/api/order/' + this.props.match.params.table_seq + '/ref').then(response => {
			this.setState({
				ref: response.data.ref
			}, () => {
				
				if (this.state.ref != 0 && this.state.ref != undefined) {
					Axios.get('/api/order/' + this.state.ref + '/sumorder').then(response => {
						this.setState({
							sumOrder: response.data
						})
					})
				}
				
			});
		});
		
		// 현재 테이블의 주문 정보를 가져옴.
		Axios.get('/api/order/' + this.props.match.params.table_seq).then(response => {
			this.setState({
				tableOrder: response.data
			});
		});
		
		// 카테고리의 목록을 가져옴.
		Axios.get('/api/menu').then((response) => {
			this.setState({
				category: response.data
			});
		});
		
		
		// 선택한 카테고리의 메뉴 목록을 가져옴
		if (this.state.activeTab != '') {
			Axios.get("/api/category/menulists/" + this.state.activeTab).then(response => {
				this.setState({
					menus: response.data
				});
			});
		}
		
		// 현재 테이블의 상태 정보를 가져옴
		Axios.get('/api/table/' + this.props.match.params.table_seq).then(response => {
			this.setState({
				table: response.data
			});
		});
		
	};
	
	toggle = (CATEG_NAME) => {
		if (this.state.activeTab !== CATEG_NAME) {
			this.setState({
				activeTab: CATEG_NAME
			}, () => {
				this.dataUpdater();
			});
		}
	};
	
	setIntervalAndExecution = (callback, timeout) => {
		callback();
		return (setInterval(callback, timeout));
	};
	
	crudClickEventHandler = (menu) => {
		// menu_seq, table_seq, ref
		this.setState({
			menu: {...menu}
		}, () => {
			Axios.post('/api/order', Qs.stringify({
					table_seq: this.props.match.params.table_seq,
					menu_seq: this.state.menu.menu_seq,
					ref: this.state.ref
				})
			).then(response => {
				this.dataUpdater();
			});
		});
	};
	
	paymentBtn = () => {
		Axios.post('/api/invoice', Qs.stringify({
			table_seq: this.props.match.params.table_seq,
			ref: this.state.ref
		}));
	};
	
	render() {
		
		const lists = this.state.tableOrder.map(item => (
				<Table_OrderList
					key={item.menu_seq}
					item={item}
					table_seq={this.props.match.params.table_seq}
					add={this.crudClickEventHandler}
					dataUpdater={this.dataUpdater}
				/>
			)
		);
		
		if (this.state.ref == undefined && this.state.ref != 0) {
			return <div></div>
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
								<h1 className={"content-header-1"}>{this.state.table.table_name}</h1>
								
								<div className={"row"}>
									<div className={"col"}>
										<h4 className={"content-header-4"}>주문 내역</h4>
										<div className={"content-box"}>
											
											<div style={{height: "430px"}}>
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
											<div>
												<table className="table">
													<tr>
														<td>주문 합계 금액 :</td>
														<td className={"text-right"}>{Comma(this.state.sumOrder)} 원</td>
													</tr>
												</table>
											</div>
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
											dataUpdater={this.dataUpdater}
										/>
										<div>
											
											<Row style={{padding: "15px", width: "100%", height: "100%"}}>
												<Col style={{width: "100%", height: "100%", padding: "15px"}}>
													{/*<Link to="/">*/}
													{/*<Button*/}
													{/*onClick={this.paymentBtn}*/}
													{/*style={{width: "100%", height: "70px"}}*/}
													{/*color="primary" size="lg"*/}
													{/*name="new"*/}
													{/*>결제</Button>*/}
													{/*</Link>*/}
													
													<Table_Payment
														onClick={this.paymentBtn}
													/>
												
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
						
						
						</div>}
				</Spring>
			
			)
		}
	}
	
	componentWillUnmount = () => {
		clearInterval(this.interval);
	}
}

export default Table_Main;