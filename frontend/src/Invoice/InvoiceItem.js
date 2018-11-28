import React from 'react';

class Invoice_Item extends React.Component {
	
	static defaultProps = {
		data : []
	};
	
	render(){
		
		const { invoice_seq, discount_amount, final_amount, menu_amount, paid_date, payment_method, ref, store_seq, sumorder, table_seq, tax_amount, total_amount } = this.props.invoice;
		
		return (
			<tr onClick={()=>{this.props.select(this.props.invoice)}}>
				<td>{paid_date.substring(0, 10)}</td>
				<td>{paid_date.substring(11, 19)}</td>
				<td>{final_amount} ₩</td>
			</tr>
		)
	}
}

export default Invoice_Item;