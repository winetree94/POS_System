import React, {Component} from 'react';
import {Button, Modal, ModalHeader, ModalBody, ModalFooter, Row, Col} from 'reactstrap';
import Axios from "axios";
import qs from "qs";

class CashbookEdit extends Component {
	
	state = {
		modal: false,
		modal2: false,
		inputName: "입금",
		outputName: "출금",
		cash_deposit: '',
	};
	
	
	constructor(props) {
		super(props);
		
		
		this.toggle = this.toggle.bind(this);
		this.toggle2 = this.toggle2.bind(this);
	}
	
	
	toggle() {
		this.setState({
			modal: !this.state.modal,
			
		});
	}
	
	toggle2() {
		this.setState({
			modal2: !this.state.modal2,
		});
	}
	
	
	changeHandler = (e) => {
		this.setState({
			[e.target.name]: e.target.value,
		});
	};
	
	changeHandler2 = (e) => {
		this.setState({
			[e.target.name]: -e.target.value,
		});
	};
	
	
	submitHandler = (e) => {
		e.preventDefault();
		console.log("디파짓" + this.state.cash_deposit);
		this.props.onCreate(this.state);
		this.setState({
			cash_deposit: '',
			modal: false,
			modal2: false
		})
	};
	
	submitHandler2 = (e) => {
		e.preventDefault();
		
		Axios.post('/api/cashbook', qs.stringify({
				cash_deposit: this.state.cash_deposit
			})
		);
		
		this.setState({
			cash_deposit: '',
			modal: false,
			modal2: false
		})
		
	};
	
	
	render() {
		return (
			<div>
				<div className="content-box" style={{height: "400px"}}>
				
				
				</div>
				<Row style={{padding: "15px", width: "100%", height: "100%"}}>
					
					<Col style={{width: "100%", height: "100%", padding: "15px"}}>
						<Button color="primary" onClick={this.toggle} style={{width: "100%", height: "70px"}}>{this.state.inputName}</Button>
						<Modal isOpen={this.state.modal} fade={false} toggle={this.toggle}
						       className={this.props.className}>
							<ModalHeader toggle={this.toggle}>현금 {this.state.inputName}액을 넣어주세요.</ModalHeader>
							<form method="post" onSubmit={this.submitHandler}>
								<ModalBody>
									<div>
										<input type="text" name='cash_deposit' placeholder="금액을 입력해주세요"
										       onChange={this.changeHandler} value={this.state.cash_deposit}
										       className="form-control"/>
									</div>
								</ModalBody>
								<ModalFooter>
									<Button color="primary" type="submit"> 확인 </Button>
									<Button color="secondary" onClick={this.toggle}>취소 </Button>
								</ModalFooter>
							
							</form>
						</Modal>
					</Col>
					
					
					<Col style={{width: "100%", height: "100%", padding: "15px"}}>
						<Button color="danger" onClick={this.toggle2} style={{width: "100%", height: "70px"}}>{this.state.outputName}</Button>
						<Modal isOpen={this.state.modal2} fade={false} toggle={this.toggle2}
						       className={this.props.className}>
							<ModalHeader toggle={this.toggle2}>현금 {this.state.outputName}액을 넣어주세요.</ModalHeader>
							
							<form onSubmit={this.submitHandler2}>
								<ModalBody>
									<input type="text" name="cash_deposit" className="form-control"
									       onChange={this.changeHandler2}/>
								</ModalBody>
								<ModalFooter>
									<Button color="primary" type="submit">확인</Button>
									<Button color="secondary" onClick={this.toggle2}>취소 </Button>
								</ModalFooter>
							
							</form>
						
						</Modal>
					</Col>
				
				
				</Row>
			</div>
		);
	}
}

export default CashbookEdit;