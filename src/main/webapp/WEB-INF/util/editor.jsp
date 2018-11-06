<link href="https://cdn.quilljs.com/1.2.2/quill.snow.css" rel="stylesheet">
<script src="https://cdn.quilljs.com/1.2.2/quill.js"></script>

	<form id="editor-form" onsubmit="return submitContents()">
		<div>
			<input type="text" class="writer" name="writer" placeholder="writer">
			<input type="text" class="title" name="title" placeholder="title">
			<input type="date" class="date" name="date" placeholder="date">
			<div id="editor-container"></div>
			<input type="hidden" class="contents" name="contents" value="">
			<div class="file"></div>
			<input type="submit" value="submit">
		</div>
	</form>

<script>

	window.onload = function () {
		var quill = new Quill('#editor-container', {
			theme: 'snow'
		});

		var form = document.querySelector('#editor-form');
		form.setAttribute("action", form_action);
		form.setAttribute("class", form_class);
		form.setAttribute("method", form_method);
		form.setAttribute("enctype", form_enctype);

		if (use_file) {
			document.querySelector('div.file').innerHTML = "<input type='file' name='image'>";
		}
	}

	function submitContents() {

		var data = document.querySelector('.ql-editor').innerHTML;
		document.querySelector('.contents').value = data;

		return true;
	}

</script>