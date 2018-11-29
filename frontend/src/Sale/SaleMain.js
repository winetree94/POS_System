import React from "react";
import Sale_TableList from "./Sale_TableList";
import Axios from "axios";
import Loading from "../comm/Loading";

export default class SaleMain extends React.Component {
	
	state = {
		tableList: [],
		isLoad: false
	};
	
	componentDidMount = () => {
		this.interval = setInterval(() => {
			Axios.get("/api/table").then((response) => {
				this.setState({
					tableList: response.data,
					isLoad: true
				});
			});
		}, 1000);
	};
	
	render() {
		
		const {isLoad, tableList} = this.state;
		
		if (!isLoad) {
			return <Loading msg="현재 매장 정보를 불러오는 입니다."/>
		} else {
			
			return (
				<div className={"container content"}>
					<h1 className={"content-header-1"}>현재 매장의 정보</h1>
					<div className={"row"}>
						<div className={"col"}>
							<h4 className={"content-header-4"}>테이블 상태</h4>
							<Sale_TableList tableList={tableList} />
						</div>
					</div>
				</div>
			);
		}
	}
	
	componentWillUnmount() {
		clearInterval(this.interval);
	}
}