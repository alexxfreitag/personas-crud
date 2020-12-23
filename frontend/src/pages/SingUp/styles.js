import styled from 'styled-components';

export const Container = styled.div`
  display: flex;
`;

export const Form = styled.form`
  margin: 80px auto 0;
  padding: 32px;
  max-width: 600px;
  width: 100%;
  display: flex;
  flex-direction: column;
  background: #fff;
  box-shadow: 4px 4px 15px rgba(0, 0, 0, 0.5);
  border-radius: 5px;

  p {
    font-size: 18px;
    margin: 5px;
  }
`;
