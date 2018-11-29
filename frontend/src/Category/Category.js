import React from 'react';

class Category extends React.Component {
	render(){
		return (
			<div className={"container content"}>
				
				<h1 className={"content-header-1"} onClick={this.clickEventHandler}>
					메뉴 관리
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

export default Category;
