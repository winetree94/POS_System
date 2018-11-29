import React, {Component} from 'react';
import { Button, ModalBody, ModalFooter } from 'reactstrap';


class CashbookModal extends Component {
    state={
        inputVal : '',
        outputVal : ''
    }

    changeHandler = (e) =>{
    this.setState({
    [e.target.inputVal] : e.target.value
    });
    };

    submitHandler = (e) =>{
        e.preventDefault();
        this.props.onCreate(this.state);
        this.setState({
            inputVal : '',
            outputVal : ''
        })
    };


    render() {
        return (


            <form onSubmit={this.submitHandler}>
                <ModalBody>
            <div>
                <input type="text" name="inputVal" placeholder="금액을 입력해주세요" onChange={this.changeHandler} className="form-control" value={this.state.inputVal}/>
            </div>
                </ModalBody>
                <ModalFooter>
                    <Button color="primary" > 확인 </Button>{' '}
                    <Button color="secondary" >취소 </Button>
                </ModalFooter>



            </form>

        );
    }
}

export default CashbookModal;