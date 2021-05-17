FROM mongo

COPY init.json /init.json
CMD mongoimport --host mongo-database --db doodlesDB --collection PollCollection --authenticationDatabase admin --username root --password root --type json --file /init.json --jsonArray