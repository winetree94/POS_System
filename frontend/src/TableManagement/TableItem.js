import React from 'react';

class TableItem extends React.Component{
	static defaultProps = {
	};
	
	render() {
		
		const {store_seq, table_name, reservation, min_people, max_people, delflag} = this.props.tableItem;
		
		return (
			<tr onClick={()=>{this.props.onClick(this.props.tableItem)}}>
				<td>{table_name}</td>
				<td>{max_people} 명</td>
			</tr>
		)
	}
	
}

export default TableItem;