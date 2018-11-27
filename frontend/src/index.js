import React from 'react';
import ReactDOM from 'react-dom';
import App from './App.js';
import 'bootstrap/dist/css/bootstrap.min.css';
import './static/css/style.css';
import * as serviceWorker from './serviceWorker';
import {BrowserRouter} from "react-router-dom";

ReactDOM.render(
	<BrowserRouter>
		<App/>
	</BrowserRouter>
	, document.getElementById('root'));
serviceWorker.unregister();