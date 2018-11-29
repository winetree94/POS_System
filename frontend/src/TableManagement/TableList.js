import React from 'react';
import TableItem from "./TableItem";


class TableList extends React.Component {
	
	render() {
		const {tableList, onClick} = this.props;
		const lists = tableList.map(tableItem => (
			<TableItem
				key={tableItem.table_seq}
				tableItem={tableItem}
				onClick={onClick}
			/>
		));
		
		return (
			<div className={"content-box"}>
				
				<table className="table">
					<thead>
					<tr>
						<th>테이블 이름</th>
						<th>최대 인원</th>
					</tr>
					</thead>
					<tbody>
					{lists}
					</tbody>
				</table>
			</div>
		)
	}
}

export default TableList;