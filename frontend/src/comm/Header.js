import React from 'react';
import {
	Collapse,
	Navbar,
	NavbarToggler,
	NavbarBrand,
	Nav,
	NavItem,
	NavLink
} from 'reactstrap';
import '../css/style.css';

export default class Header extends React.Component {
	
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
			<div>
				<div>
					<Navbar color="light" light expand="md">
						<NavbarBrand href="/">POS</NavbarBrand>
						<NavbarToggler onClick={this.toggle} />
						<Collapse isOpen={this.state.isOpen} navbar>
							<Nav className="ml-auto" navbar>
								<NavItem>
									<NavLink href="/components/">winetree</NavLink>
								</NavItem>
								<NavItem>
									<NavLink href="https://github.com/reactstrap/reactstrap">로그아웃</NavLink>
								</NavItem>
							</Nav>
						</Collapse>
					</Navbar>
				</div>
			</div>
		)
	}
}