import React, {Fragment} from 'react';

const Loading = (props) => {
		return (
			<Fragment>
				<div className="spinner">
					<div className="double-bounce1"></div>
					<div className="double-bounce2"></div>
				</div>
				<h1 className={"display-5 text-center"}>{props.msg}</h1>
			</Fragment>
		)
}

export default Loading;