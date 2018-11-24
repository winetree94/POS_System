import React, {Fragment} from 'react';

export default class SidebarItem extends React.Component {
	
	static defaultProps = {
		name : '기본 이름'
	}
	
	render(){
		return (
			<Fragment>
				<p>{this.props.name}</p>
			</Fragment>
		)
	}
}