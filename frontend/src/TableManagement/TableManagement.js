import React from 'react';
import Axios from 'axios';
import Loading from "../comm/Loading";
import TableList from "./TableList";
import TableDetail from "./TableDetail";
import Qs from "qs";
import {Spring, Trail} from "react-spring";

class TableManagement extends React.Component {
	
	state = {
		
		tableList: [],
		tableDetail: {},
		isLoad: false,
		detailSwitch: true
		
	};
	
	componentDidMount() {
		this.interval = this.setIntervalAndExecution(this.dataUpdater, 3000);
	};
	
	setIntervalAndExecution = (callback, timeout) => {
		callback();
		return (setInterval(callback, timeout));
	};
	
	dataUpdater = () => {
		Axios.get("/api/table").then((response) => {
			this.setState({
				tableList: response.data,
				isLoad: true
			});
		});
	};
	
	detailViewEventHandler = (detail) => {
		this.setState({
			tableDetail: {...detail},
			detailSwitch: true
		});
	};
	
	detailViewChangeHandler = (e) => {
		e.preventDefault();
		this.setState({
			tableDetail: {
				...this.state.tableDetail,
				[e.target.id]: e.target.value
			}
		});
	};
	
	render() {
		const {tableList, tableDetail, isLoad} = this.state;
		
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
								
								<h1 className={"content-header-1"}>
									<Trail
										items={['테', '이', '블', ' 관', '리']}
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
									
									<div className="col">
										<h4 className={"content-header-4"}>테이블 목록</h4>
										<TableList tableList={tableList} onClick={this.detailViewEventHandler}></TableList>
									</div>
									
									<div className="col">
										<h4 className={"content-header-4"}>테이블 상세정보</h4>
										{this.state.detailSwitch ?
											<TableDetail onClick={this.detailViewChangeHandler} dataUpdater={this.dataUpdater}
											             tableDetail={tableDetail}/> : null}
									</div>
								
								</div>
							
							</div>
						
						</div>}
				</Spring>
			
			)
		}
	}
	
	componentWillUnmount() {
		clearInterval(this.interval);
	}
}

export default TableManagement;
