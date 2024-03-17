import AppBar from '@mui/material/AppBar';
import { Box, Button, ButtonGroup, Container, IconButton, Link, Toolbar } from '@mui/material';
import './NavigationBar.scss';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';

function NavigationBar() {
    return(
        <AppBar
          style={{ backgroundColor: "rgba(5,10,15,255)", opacity: 1 }}
          position="static"
        >
          <Container>
            <Toolbar>
              <Box 
                sx={{
                  justifyContent: "space-evenly",
                  flexGrow: 1,
                  display: { xs: "flex" },
                }}
              >
              <ButtonGroup>
                <Button
                  className='button'
                  style={{ backgroundColor: "rgba(10, 40, 40, 0.3)", opacity: 0.95, color: "white" }}
                  key="home"
                  sx={{ my: 2, color: "black", display: "block" }}
                  variant="contained"
                  component={Link}
                  href="/"
                >
                  Home
                </Button>
                <Button
                  className='button'
                  style={{ backgroundColor: "rgba(10, 40, 40, 0.3)", opacity: 0.95, color: "white" }}
                  key="rent"
                  sx={{ my: 2, color: "black", display: "block" }}
                  variant="contained"
                  component={Link}
                  href="/"
                >
                  Ausleihen
                </Button>
                <Button
                  className='button'
                  style={{ backgroundColor: "rgba(10, 40, 40, 0.3)", opacity: 0.95, color: "white" }}
                  key="market"
                  sx={{ my: 2, color: "black", display: "block" }}
                  variant="contained"
                  component={Link}
                  href="/"
                >
                  Marktplatz
                </Button>
                <Button
                  className='button'
                  style={{ backgroundColor: "rgba(10, 40, 40, 0.3)", opacity: 0.95, color: "white" }}
                  key="service"
                  sx={{ my: 2, color: "black", display: "block" }}
                  variant="contained"
                  component={Link}
                  href="/"
                >
                  Service
                </Button>
              </ButtonGroup>
              <ButtonGroup>
                <IconButton aria-label="delete" color="secondary" href="/profil">
                  <AccountCircleIcon />
                </IconButton>
              </ButtonGroup>
              </Box>
            </Toolbar>
          </Container>
        </AppBar>
    );
}

export default NavigationBar;