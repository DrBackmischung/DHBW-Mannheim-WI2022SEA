import { Card, Grid } from '@mui/material'
import './Cats.scss'
import { useQuery } from "react-query";
import { FidgetSpinner } from 'react-loader-spinner';

function Cats() {
  const apiUrlAll = `http://localhost:8080/cats`;
  const {isLoading, isError, data} : any = useQuery("Cats", () =>
      fetch(apiUrlAll).then((res) => res.json())
  );
  if(isLoading) {
      return(
          <FidgetSpinner />
      )
  }

  if(isError) {
      return(
          <p>Error!</p>
      )
  }
  return (
    <>
      <h1>Cats :3</h1>
      <FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><br></br>
      <FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><br></br>
      <FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><br></br>
      <FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><br></br>
      <FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><br></br>
      <FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><br></br>
      <FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><br></br>
      <FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><br></br>
      <FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><br></br>
      <FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><br></br>
      <FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><br></br>
      <FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><br></br>
      <FidgetSpinner /><FidgetSpinner /><FidgetSpinner /><br></br><FidgetSpinner />
      <Grid container>

        {data.map((entry : any) => (
            <Grid item key={entry.title} xs={12}>
                <h1>{entry.firstName}</h1>
                <h4>{entry.lastName}</h4>
                <h4>Farbe: {entry.color}</h4>
                <h4>Alter: {entry.age}</h4>
            </Grid>
        ))}

      </Grid>
    </>
  )
}

export default Cats
