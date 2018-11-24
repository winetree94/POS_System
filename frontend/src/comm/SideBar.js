import React, {Fragment} from 'react';
import SideBarItem from './SidebarItem.js';

export default class SideBar extends React.Component {
	
	render(){
		return (
			<Fragment>
				<SideBarItem name={"판매"}></SideBarItem>
				<SideBarItem name={"분석"}></SideBarItem>
				<SideBarItem name={"관리"}></SideBarItem>
				<SideBarItem name={"판매 분석"}></SideBarItem>
				<SideBarItem name={"현금출납부"}></SideBarItem>
			</Fragment>
		)
	}
}