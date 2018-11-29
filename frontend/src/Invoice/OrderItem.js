import React from 'react';
import comma from '../utility/common-utility';

// const OrderItem = (props) => {
// 	console.log(props);
//     return (
//       <tr>
//         <td>{props.order.menu_name}</td>
//         <td className="text-right">{props.order.price}</td>
// 	      <td>{props.order.count}</td>
//         <td className="text-right">{comma(props.order.sum)}</td>
//       </tr>
//     )
// }



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
				<td className="text-right">{comma(this.props.order.price)}</td>
				<td>{this.props.order.count}</td>
				<td className="text-right">{comma(this.props.order.sum)}</td>
			</tr>
		)
	}
}

export default OrderItem;
