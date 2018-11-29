import React from 'react';
import comma from '../utility/common-utility';

class OrderItem extends React.Component {
	
	static defaultProps = {
		order : {
			menu_name : '',
			price : '',
			count : '',
			sum : '',
			menu_seq : ''
		}
	};
	
	render(){
		return (
			<tr>
				<td>{this.props.order.menu_name}</td>
				<td>{comma(this.props.order.price)}</td>
				<td>{this.props.order.count}</td>
				<td className="text-right">{comma(this.props.order.sum)}</td>
			</tr>
		)
	}
}

export default OrderItem;
