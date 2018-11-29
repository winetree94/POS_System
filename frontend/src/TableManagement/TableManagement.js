import React from 'react';
import Axios from 'axios';
import Loading from "../comm/Loading";
import TableList from "./TableList";
import TableDetail from "./TableDetail";
import Qs from "qs";

class TableManagement extends React.Component {
	
	state = {
		
		tableList: [],
		tableDetail: {},
		isLoad: false,
		detailSwitch:true
		
	};
	
	componentDidMount() {
		this.interval = setInterval(() => {
			Axios.get("/api/table").then((response) => {
				this.setState({
					tableList: response.data,
					isLoad: true
				});
			});
		}, 1000);
	};
	
	detailViewEventHandler = (detail) => {
		this.setState({
			tableDetail: {...detail},
			detailSwitch : true
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
			return (<Loading msg="테이블 관리 로딩중입니다."></Loading>)
		} else {
			
			return (
				<div className={"container content"}>
					
					<h1 className={"content-header-1"}>
						테이블 관리
					</h1>
					
					<div className={"row"}>
						
						<div className="col">
							<h4 className={"content-header-4"}>테이블 목록</h4>
							<TableList tableList={tableList} onClick={this.detailViewEventHandler}></TableList>
						</div>
						
						<div className="col">
							<h4 className={"content-header-4"}>테이블 상세정보</h4>
							{this.state.detailSwitch?<TableDetail onClick={this.detailViewChangeHandler} tableDetail={tableDetail}/>:null}
						</div>
					
					</div>
				
				</div>
			)
		}
	}
	
	componentWillUnmount() {
		clearInterval(this.interval);
	}
}

export default TableManagement;
