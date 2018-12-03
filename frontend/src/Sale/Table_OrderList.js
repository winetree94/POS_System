import React from 'react';
import {Button, ButtonGroup, Popover, PopoverBody, PopoverHeader} from "reactstrap";
import Axios from "axios";
import Comma from '../utility/common-utility';

class Table_OrderList extends React.Component {
	
	state = {
		popoverOpen : false
	};
	
	static defaultProps = {
		item : {
			menu_seq : '',
			menu_name : '',
			price : '',
			sum : ''
		},
			table_seq : ''
	};
	
	
	toggle = () => {
		this.setState({
			popoverOpen: !this.state.popoverOpen
		});
	};
	
	clickRemove=()=>{
		const {menu_seq} = this.props.item;
		Axios.delete('/api/order/'+this.props.table_seq +'/'+menu_seq);
	};
	
	
	render(){
		
		const { menu_seq, menu_name, count, price, sum }  = this.props.item;
		
		return (
			<tr id={"popover" + menu_seq} onClick={this.toggle}>
				<td>{menu_name}</td>
				<td>{count}</td>
				<td>{Comma(price)} 원</td>
				<td>{Comma(sum)} 원</td>
				<Popover placement="left" isOpen={this.state.popoverOpen} target={"popover" + menu_seq} toggle={this.toggle}>
					<PopoverBody>
						<ButtonGroup>
							<Button color="danger" onClick={this.clickRemove}> - </Button>
							<Button>{count}</Button>
							<Button color="primary" onClick={()=>{this.props.add(this.props.item)}}> + </Button>
						</ButtonGroup>
					</PopoverBody>
				</Popover>
			</tr>
		)
	}
}

export default Table_OrderList;