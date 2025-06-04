# weatherWidget Backend

Custom backend so calls made for weather data do not expend an excessive number of apikey tokens.

Run it using the following command in a terminal after starting up Docker:

docker run -e "nimbus.api.secret=[APIKEYHERE]" -p 8080:8080 -t emilvdijk/nimbusbackend:latest