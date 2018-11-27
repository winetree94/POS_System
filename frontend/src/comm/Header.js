import React, {Fragment} from 'react';
import {
	Collapse,
	Navbar,
	NavbarToggler,
	NavbarBrand,
	Nav,
	NavItem,
	NavLink
} from 'reactstrap';
import '../static/css/style.css';

export default class Header extends React.Component {
	
	static defaultProps = {
		service_id : "null"
	}
	
	constructor(props) {
		super(props);
		this.toggle = this.toggle.bind(this);
		this.state = {
			isOpen: false
		};
	}
	
	toggle() {
		this.setState({
			isOpen: !this.state.isOpen
		});
	}
	
	render() {
		return (
			<Fragment>
				<Navbar color="light" light expand="md">
					<div className={"container"} style={{maxWidth:"1280px"}}>
						<NavbarBrand href="/">POS</NavbarBrand>
						<NavbarToggler onClick={this.toggle}/>
						<Collapse isOpen={this.state.isOpen} navbar>
							<Nav className="ml-auto" navbar>
								<NavItem>
									<NavLink href="#">{this.props.service_id}</NavLink>
								</NavItem>
								<NavItem>
									<NavLink href="#">로그아웃</NavLink>
								</NavItem>
							</Nav>
						</Collapse>
					</div>
				</Navbar>
			</Fragment>
		)
	}
}