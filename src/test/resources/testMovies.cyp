CREATE (a:Actor {name: 'Keanu Reeves'})-[:ACTED_IN]->(m:Movie {name: 'Matrix', duration: 90})-[:IN_GENRE]->(g:Genre {name: 'action'}),
       (:Director {name: 'Wachowski bros'})-[:DIRECTED]->(m)<-[:RATED]-(:User {nickname: 'User777'}),
       (:Actor {name: 'Hugo Weaving'})-[:ACTED_IN]->(m), (a)-[:ACTED_IN]->(:Movie {name: 'John Wick', duration: 100})-[:IN_GENRE]->(g);