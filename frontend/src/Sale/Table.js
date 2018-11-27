import React from 'react';

class Table extends React.Component {
	
	static defaultProps = {
		data : []
	};
	
	render(){
		return (
			<div>
				<p>{JSON.stringify(this.props.data)}</p>
			</div>
		)
	}
}

export default Table;