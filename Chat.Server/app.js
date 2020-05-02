var express = require("express");
var app = express();
app.set("views", "./views");

var server = require("http").createServer(app);
var io = require("socket.io")(server);

const port = process.env.PORT || 3000;
server.listen(port);

console.log("Server running...");

// Rooms with 1 user
var availableRooms = [];

io.sockets.on("connection", function(socket) {
    // Khi user connect, server sẽ cấp 1 id cho họ
    socket.emit("server-send-userId", socket.id);

    // As login
    socket.on("client-send-username", function(user_name) {
        socket.name = user_name;
        if (availableRooms.length > 0) {
            socket.leave(socket.id);
    
            var roomId = availableRooms.pop();
            socket.join(roomId, function() {
                io.in(roomId).emit("server-send-roomId", roomId);
            });
        } else {
            availableRooms.push(socket.id);
        }

        //socket.emit("server-send-login-result", socket.id, socket.id);
    });

    socket.on("disconnect", function() {
        var pos = availableRooms.indexOf(socket.id);
        if (port != -1) {
            availableRooms.splice(pos, 1);
        }
    })

    socket.on("client-send-message", function(roomId, message) {
        var date = new Date();
        var time = date.getHours() + ":" + date.getMinutes();

        io.sockets.in(roomId).emit("server-send-message", socket.id, socket.name, message, time);
    });
});