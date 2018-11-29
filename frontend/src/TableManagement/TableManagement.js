import React from 'react';

class TableManagement extends React.Component {
	render(){
		return (
			<div className={"container content"}>
				
				<h1 className={"content-header-1"} onClick={this.clickEventHandler}>
					테이블 관리
				</h1>
				
				<div className={"row"}>
					<div className={"col content-box"}>
					</div>
					<div className={"col content-box"}>
					</div>
				</div>
			
			</div>
		)
	}
}

export default TableManagement;
