# HS110 plug controller

Reads the plug state every second and
- saves result to database
- publishes result to `topic/readings` websocket.

You need to know the IP-address of the plug and set it in `docker-compose.yml`.

Some GET-endpoints:
- `/open`: Opens the plug relay
- `/close`: Closes the plug relay
- `/info`: Returns info on the plug
- `/reset`: Resets the plug to factory settings
- `/history`: Returns readings from the past 10 minutes
