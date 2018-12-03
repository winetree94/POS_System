import React, {Fragment} from 'react';
import {Button, Modal, ModalHeader, ModalBody, ModalFooter, InputGroup, InputGroupAddon, Input} from 'reactstrap';
import {Link} from "react-router-dom";

class Table_Payment extends React.Component {
	
	state = {
		modal : false
	};

	toggle = () => {
		this.setState({
			modal: !this.state.modal
		});
	};
	
	render(){
		return (
			<Fragment>
				<Button
					style={{width: "100%", height: "70px"}}
					color="primary" size="lg"
					onClick={this.toggle}
				>결제</Button>
				<Modal isOpen={this.state.modal} toggle={this.toggle} className={this.props.className} style={{maxWidth:"300px"}}>
					<ModalHeader toggle={this.toggle} className="text-center">결제 방식을 선택하세요.</ModalHeader>
					<ModalBody style={{padding:"5px"}}>
						<Link to="/"><Button style={{width: "46%", height: "100%", margin:"5px"}} size="lg" color="primary" onClick={this.props.onClick}>현금 결제</Button></Link>
						<Button style={{width: "46%", height: "100%", margin:"5px"}} size="lg" color="secondary" onClick={this.toggle} disabled>카드 결제</Button>
					</ModalBody>
				</Modal>
			</Fragment>
		)
	}
}

export default Table_Payment;