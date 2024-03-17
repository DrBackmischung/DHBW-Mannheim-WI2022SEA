import { QueryClient, QueryClientProvider } from 'react-query';
import './App.scss'
import Cats from './Cats';
import FooterBar from './FooterBar';

const queryClient = new QueryClient();

function App() {
  return (
    <>
      <QueryClientProvider client={queryClient}>
      <Cats/>
      <FooterBar/>
      </QueryClientProvider>
    </>
  )
}

export default App
