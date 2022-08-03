const request = require('supertest');
const app = require('../index');

const countries = require('../src/countries/countries.json');

describe('GET /countries', () => {
  it('responds with a set of countries and your languages', (done) => {
    request(app).get('/countries').expect(countries, done);
  });
});
