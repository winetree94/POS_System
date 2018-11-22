import React from 'react';

export default class SidebarItem extends React.Component {
	
	static defaultProps = {
		name : '기본 이름'
	}
	
	render(){
		return (
			<div>
				<p>{this.props.name}</p>
			</div>
		)
	}
}