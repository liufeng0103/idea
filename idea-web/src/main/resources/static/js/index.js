const API_HOST = "https://api.bnade.com/idea";

/**
 * 简单封装localStorage
 */
var store = {
	set : function(key, val) {
		var str;
		if (typeof val === 'object') {
			str = JSON.stringify(val);
		} else {
			str = val;
		}
		localStorage.setItem(key, str);
	},
	/**
	 * 获取
	 * 
	 * @param key
	 * @returns object，找不到返回null
	 */
	get : function(key) {
		return JSON.parse(localStorage.getItem(key));
	}
}

function notifyMe(title, body) {
	// 先检查浏览器是否支持
	if (!("Notification" in window)) {
		alert("This browser does not support desktop notification");
	}

	// 检查用户是否同意接受通知
	else if (Notification.permission === "granted") {
		// If it's okay let's create a notification
		var notification = new Notification(title, {body: body});
	}

	// 否则我们需要向用户获取权限
	else if (Notification.permission !== 'denied') {
		Notification.requestPermission(function(permission) {
			// 如果用户同意，就可以向他们发送通知
			if (permission === "granted") {
				var notification = new Notification(title, {body: body});
			}
		});
	}

	// 最后，如果执行到这里，说明用户已经拒绝对相关通知进行授权
	// 出于尊重，我们不应该再打扰他们了
}

var topics = null;
var maxId = 0;
function loadData(firstLoad) {
	$.get(API_HOST + "/forums/nga/topics", function(data) {
		topics = data;
		// 排序
		topics.sort(function(t1, t2) {
			return t2.id - t1.id;
		});
		var currentMaxId = 0;
		for ( var i in data) {
			var topic = data[i];
			var id = topic.id;

			if (firstLoad) {
				console.log(JSON.stringify(topic));
			} else {
				// 是否是新的帖子
				if (id > maxId) {
					console.log(JSON.stringify(topic));
					notifyMe("发现新帖", topic.title);
				}
			}
			// 保存本次最大id
			if (id > currentMaxId) {
				currentMaxId = id;
			}
		}
		// 更新最新帖子id
		if (currentMaxId > maxId) {
			maxId = currentMaxId;
		}
	});
}

loadData(true);
setInterval(function() {
	loadData(false);
}, 10000);
