//https://firebase.google.com/docs/web/setup#available-libraries

const firebaseConfig = {
  apiKey: "AIzaSyD5znsVnxOUTxnEpjKhxBOVyhzfhtnSudw",
  authDomain: "cadweb-7b838.firebaseapp.com",
  projectId: "cadweb-7b838",
  storageBucket: "cadweb-7b838.appspot.com",
  messagingSenderId: "489226178773",
  appId: "1:489226178773:web:bfa493d4dcbe04a249125c",
  databaseURL: "https://cadweb-7b838-default-rtdb.firebaseio.com",
};

firebase.initializeApp(firebaseConfig);

const db = firebase.database();