import React, {Component} from 'react';
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import CashbookModal from "./Cashbook_Modal";

class CashbookEdit extends Component {

    constructor(props) {
        super(props);
        this.state = {
            modal: false,
            inputName : "입금",
            outputName : "출금"
        };

        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            modal: !this.state.modal
        });
    }

    render() {
        return (
            <div className="content-box">
                <div className="row text-right">
            <div className="col">
                <Button color="danger" onClick={this.toggle}>{this.state.inputName}</Button>
                <Modal isOpen={this.state.modal} fade={false} toggle={this.toggle} className={this.props.className}>
                    <ModalHeader toggle={this.toggle}>현금 {this.state.inputName}액을 넣어주세요.</ModalHeader>
                    <ModalBody>
                        <CashbookModal/>
                    </ModalBody>
                    <ModalFooter>
                        <Button color="primary" onClick={this.toggle}>Do Something</Button>{' '}
                        <Button color="secondary" onClick={this.toggle}>Cancel</Button>
                    </ModalFooter>
                </Modal>
            </div>


                <div className="col text-left">
                    <Button color="primary" onClick={this.toggle}>{this.state.outputName}</Button>
                    <Modal isOpen={this.state.modal} fade={false} toggle={this.toggle} className={this.props.className}>
                        <ModalHeader toggle={this.toggle}>현금 {this.state.outputName}액을 넣어주세요.</ModalHeader>
                        <ModalBody>
                            <CashbookModal/>
                        </ModalBody>
                        <ModalFooter>
                            <Button color="primary" onClick={this.toggle}>Do Something</Button>{' '}
                            <Button color="secondary" onClick={this.toggle}>Cancel</Button>
                        </ModalFooter>
                    </Modal>
                </div>




                </div>
            </div>
        );
    }
}

export default CashbookEdit;