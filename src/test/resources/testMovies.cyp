CREATE (a:Actor {name: 'Keanu Reeves'})-[:ACTED_IN]->(m:Movie {name: 'Matrix'})-[:IN_GENRE]->(g:Genre {name: 'Action'}),
       (:Director {name: 'Wachowski bros'})-[:DIRECTED]->(m)<-[:RATED]-(:User {nickname: 'User123'}),
       (:Actor {name: 'Hugo Weaving'})-[:ACTED_IN]->(m), (a)-[:ACTED_IN]->(:Movie {name: 'John Wick'})-[:IN_GENRE]->(g);