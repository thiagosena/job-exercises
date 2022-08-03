const express = require('express');
const app = express();
const port = process.env.PORT || 3000;

const countries = require('./src/countries/countries.json');

app.get('/countries', (req, res) => {
  return res.json(countries);
});

app.listen(port, () => {
  console.log(`Server is running on port ${port}`);
});
