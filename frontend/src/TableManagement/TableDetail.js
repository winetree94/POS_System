import React from 'react';
import {InputGroup, InputGroupAddon, InputGroupText, Input, Row, Col, Button} from 'reactstrap';
import Axios from 'axios';
import Qs from 'qs';

class TableDetail extends React.Component {
	
	static defaultProps = {
		tableDetail: {
			table_seq: '',
			store_seq: '',
			table_name: '',
			reservation: '',
			min_people: '',
			max_people: '',
			delflag: ''
		},
	};
	
	handleSubmit = (e) => {
		e.preventDefault();
	};
	
	onClickHandler = (e) => {
		const {store_seq, table_seq, table_name, reservation, min_people, max_people, delflag} = this.props.tableDetail;
		e.preventDefault();
		const handler = e.target.name;
		
		if (handler === "edit") {
			Axios.put('/api/table/' + table_seq, Qs.stringify({
				table_seq: table_seq,
				table_name: table_name,
				reservation: reservation,
				min_people: min_people,
				max_people: max_people
			})).then(response => {
			})
		} else if (handler === "delete") {
			Axios.delete('/api/table/' + table_seq)
		} else if (handler === "new") {
			Axios.post('/api/table', Qs.stringify({
				table_name: '새로운 테이블',
				reservation: 'N',
				min_people: '0',
				max_people: '0'
			}))
		}
	};
	
	render() {
		
		const {store_seq,table_seq, table_name, reservation, min_people, max_people, delflag} = this.props.tableDetail;
		
		return (
			<div>
				<div className={"content-box"} style={{height: "400px"}}>
					<form onSubmit={this.handleSubmit}>
						<div className="form-group">
							<InputGroup>
								<InputGroupAddon addonType="prepend">테이블 고유번호</InputGroupAddon>
								<Input readOnly="readOnly" value={table_seq} id="table_seq" onChange={this.props.onClick}/>
							</InputGroup>
						</div>
						<div className="form-group">
							<InputGroup>
								<InputGroupAddon addonType="prepend">테이블 이름</InputGroupAddon>
								<Input value={table_name} id="table_name" onChange={this.props.onClick}/>
							</InputGroup>
						</div>
						<div className="form-group">
							<InputGroup>
								<InputGroupAddon addonType="prepend">예약 가능 여부</InputGroupAddon>
								<Input value={reservation} id="reservation" onChange={this.props.onClick}/>
							</InputGroup>
						</div>
						<div className="form-group">
							<InputGroup>
								<InputGroupAddon addonType="prepend">예약 최소 인원</InputGroupAddon>
								<Input value={min_people} id="min_people" onChange={this.props.onClick}/>
							</InputGroup>
						</div>
						<div className="form-group">
							<InputGroup>
								<InputGroupAddon addonType="prepend">예약 최대 인원</InputGroupAddon>
								<Input value={max_people} id="max_people" onChange={this.props.onClick}/>
							</InputGroup>
						</div>
					</form>
				</div>
				<Row style={{padding: "15px", width: "100%", height: "100%"}}>
					<Col style={{width: "100%", height: "100%", padding: "15px"}}>
						<Button
							style={{width: "100%", height: "70px"}}
							color="primary" size="lg"
							name="new"
							onClick={this.onClickHandler}
						>만들기</Button>
					</Col>
					<Col style={{width: "100%", height: "100%", padding: "15px"}}>
						<Button
							style={{width: "100%", height: "70px"}}
							color="info" size="lg"
							name="edit"
							onClick={this.onClickHandler}
						>수정</Button>
					</Col>
					<Col style={{width: "100%", height: "100%", padding: "15px"}}>
						<Button
							style={{width: "100%", height: "70px"}}
							color="danger" size="lg"
							name="delete"
							onClick={this.onClickHandler}
						>삭제</Button>
					</Col>
				</Row>
			</div>
		)
	}
}

export default TableDetail;