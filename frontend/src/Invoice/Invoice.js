import React from "react";
import {Row, Col} from 'reactstrap';

export default class Invoice extends React.Component {
	
	state = {};
	
	componentDidMount() {
	}
	
	render() {
		return (
			<div className={"container content"}>
				<h1 className={"content-header-1"}>판매 내역</h1>
				<Row>
					<Col>
						<h1 className="content-header-4">거래 내역</h1>
						
						<div className={"content-box"}>
							<div style={{
								backgroundColor: "white",
								borderBottom: "1px solid #e6eaee",
								borderCollapse: "collapse",
								height: "74px"
							}}>
								<p className={"p-4 text-center"}>날짜 선택</p>
							</div>
							
							<div style={{borderBottom: "1px solid #e6eaee", borderCollapse: "collapse", height: "52px"}}>
								<Row>
									<Col><p className={"p-4 text-center"}>일자</p></Col>
									<Col><p className={"p-4 text-center"}>시간</p></Col>
									<Col><p className={"p-4 text-center"}>금액</p></Col>
								</Row>
								<div className={"box-fix"}></div>
							</div>
							
						</div>
						
					</Col>
					
					<Col>
						<h1 className="content-header-4">주문 목록</h1>
						<div className={"content-box"}>lkj</div>
					</Col>
				</Row>
			</div>
		);
	}
	
}