const API_HOST = "https://api.bnade.com/idea";
const NGA = 1;
const ZKB = 2;
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

class Notify {
	
	constructor(config) {
		if (!config) {
            config = {};
        }
		this.audio = config.audio || '';
		
        // 初始化生成声音文件节点
        if (this.audio && this.audio.file) {
            this.setURL(this.audio.file)
        }
	}
	
	setURL(url) {
        if (url) {
            if (this.audioElm) {
                this.audioElm.remove();
            }
            this.audioElm = this.createAudio(url);
            document.body.appendChild(this.audioElm);
        }
        return this;
    }
	
	player() {
		var adi = this.audio.file,
        source = null;
        if (!this.audio || !this.audio.file) {
            return;
        }
        if (!this.audioElm) {
            this.audioElm = this.createAudio(this.audio.file);
            document.body.appendChild(this.audioElm)
        }
        this.audioElm.play();
        return this;
	}
	
	createAudio(url) {
        var audioElm = document.createElement('audio'),
        source;
        if (this.isArray(url) && url.length > 0) {
            for (var i = 0; i < url.length; i++) {
                source = document.createElement('source');
                source.src = url[i];
                source.type = 'audio/' + getExtension(url[i]);
                audioElm.appendChild(source);
            }
        } else {
            audioElm.src = url;
        }
        return audioElm;
    }
	
	isArray(value) {
        return Object.prototype.toString.call(value) === '[object Array]';
    }
}

let notify = new Notify({audio:{file:"https://www.bnade.com/bnade/dd.mp3"}});

class Resource {
	
	getTopics(type) {
		var result;
		$.ajax({
			url : this.generateUrl(type),
			async : false,
			success : function(data) {
				result = data;
			},
			error : function(xhr) {
				console.err("错误：" + xhr.status + " " + xhr.statusText);
			},
		});
		return result;
	}
	
	generateUrl(type) {
		if (type == NGA) {
			return API_HOST + "/forums/nga/topics";
		} else if (type == ZKB) {
			return API_HOST + "/forums/zkb/topics";
		}
	}
}

class App {

	constructor(type) {
	    this.type = type;
	    this.topics = [];
	    this.maxId = 0;
	    this.resource = new Resource();
	}
	
	loadData(firstLoad) {
		var data = this.resource.getTopics(this.type);
		if (data.length > 0) {
			this.topics = data;
			// 排序
			data.sort(function(t1, t2) {
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
					if (id > this.maxId) {
						console.log(JSON.stringify(topic));
						notifyMe("发现新帖", topic.title);
//						notify.player();
					}
				}
				// 保存本次最大id
				if (id > currentMaxId) {
					currentMaxId = id;
				}
			}
			// 更新最新帖子id
			if (currentMaxId > this.maxId) {
				this.maxId = currentMaxId;
			}
		}
	}
}

let ngaApp = new App(NGA);
ngaApp.loadData(true);
setInterval(function() {
	ngaApp.loadData(false);
}, 10000);

let zkbApp = new App(ZKB);
zkbApp.loadData(true);
setInterval(function() {
	zkbApp.loadData(false);
}, 10000);


