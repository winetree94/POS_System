import React, {Fragment} from 'react';

const ErrorPage = (props) => {
	return (
		<Fragment>
			<div>
				<h1 className={"display-5 text-center"}>{props.msg}</h1>
			</div>
		</Fragment>
	)
}

export default ErrorPage;